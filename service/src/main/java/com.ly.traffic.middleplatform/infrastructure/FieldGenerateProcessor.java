package com.ly.traffic.middleplatform.infrastructure;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;
import java.io.Writer;
import java.util.Set;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.infrastructure
 * @Description: ${TODO}
 * @date 2020/7/6 17:15
 */
// 支持的java版本 java8
@SupportedSourceVersion(SourceVersion.RELEASE_8)
// 该处理器要处理的注解
@SupportedAnnotationTypes("com.ly.traffic.middleplatform.infrastructure.GenerateField")
public class FieldGenerateProcessor extends AbstractProcessor {
    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        StringBuilder builder = new StringBuilder()
                .append("package com.ly.traffic.middleplatform.infrastructure; \n\n")
                .append("public class GeneratedCalss {\n\n")
                .append("\tpublic String getMessage() {\n")
                .append("\t\treturn \"");

        for (Element element : roundEnv.getElementsAnnotatedWith(GenerateField.class)) {
            String objectType = element.getSimpleName().toString();
            builder.append(objectType).append(" says hello!\\n");
        }

        builder.append("\";\n")
                .append("\t}\n")
                .append("}\n");
        try {
            JavaFileObject source = processingEnv.getFiler().createSourceFile("com.ly.traffic.middleplatform.infrastructure.GeneratedCalss");
            Writer writer = source.openWriter();
            writer.write(builder.toString());
            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return true;
    }
}
