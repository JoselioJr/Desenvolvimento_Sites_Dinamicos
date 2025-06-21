package com.exemplo.produtos;

import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ProdutosApplication implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {
        // 1. Cria o contexto da aplicação Spring e registra a configuração Java
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebConfig.class);

        // 2. Cria e registra o DispatcherServlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", dispatcherServlet);

        // 3. Configura o DispatcherServlet
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
        registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");

        // 4. Configuração de multipart (upload de arquivos)
        // Diretório temporário padrão (pode personalizar)
        String location = System.getProperty("java.io.tmpdir");

        // maxFileSize = 5MB, maxRequestSize = 20MB, fileSizeThreshold = 0
        MultipartConfigElement multipartConfig = new MultipartConfigElement(location, 5 * 1024 * 1024, 20 * 1024 * 1024, 0);
        registration.setMultipartConfig(multipartConfig);
    }
}