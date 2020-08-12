/**
 *
 */
package com.ly.traffic.middleplatform.infrastructure.configure;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.util.ClassUtils;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import static org.springframework.util.StringUtils.tokenizeToStringArray;

/**
 * 主要解决typeAliasesPakcage不支持通配符的问题
 *
 * @author leeyazhou
 *
 */
public class SqlSessionFactoryBeanAdaptor extends SqlSessionFactoryBean {
	private static final Logger logger = LoggerFactory.getLogger(SqlSessionFactoryBeanAdaptor.class);

	@Override
	public void setTypeAliasesPackage(String typeAliasesPackages) {
		Set<String> result = new TreeSet<String>();
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(resolver);

		String[] typeAliasPackageArray = tokenizeToStringArray(typeAliasesPackages, ConfigurableApplicationContext.CONFIG_LOCATION_DELIMITERS);
		for(String typeAliasesPackage : typeAliasPackageArray) {
			typeAliasesPackage = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + ClassUtils.convertClassNameToResourcePath(typeAliasesPackage) + "/**/*.class";

			// 将加载多个绝对匹配的所有Resource
			// 将首先通过ClassLoader.getResource("META-INF")加载非模式路径部分
			// 然后进行遍历模式匹配
			try {
				Resource[] resources = resolver.getResources(typeAliasesPackage);
				if (resources != null && resources.length > 0) {
					MetadataReader metadataReader = null;
					for (Resource resource : resources) {
						if (resource.isReadable()) {
							metadataReader = metadataReaderFactory.getMetadataReader(resource);
							try {
								final String packageName = Class.forName(metadataReader.getClassMetadata().getClassName()).getPackage().getName();
								boolean contained = false;
								for(String item : result) {
									if(packageName.startsWith(item)) {
										contained = true;
									}
								}
								if(!contained) {
									result.add(packageName);
								}
							} catch (ClassNotFoundException e) {
								logger.error("",e);
							}
						}
					}
				}
			} catch (IOException e) {
				logger.error("", e);
			}
		}

		if (result.size() > 0) {
			super.setTypeAliasesPackage(StringUtils.join(result.toArray(), ","));
		} else {
			logger.warn("参数typeAliasesPackage:" + typeAliasesPackages + "，未找到任何包");
		}
	}

}
