package com.expercise.interceptor;

import com.expercise.service.configuration.ConfigurationService;
import com.expercise.service.user.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommonViewParamsInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private ConfigurationService configurationService;

    @Autowired
    private AuthenticationService authenticationService;

    @Value("${build.id}")
    private String buildId;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        if (modelAndView == null) {
            return;
        }

        modelAndView.addObject("buildId", buildId);
        modelAndView.addObject("developmentEnvironment", configurationService.isDevelopment());
        modelAndView.addObject("googleAnalyticsScript", configurationService.getGoogleAnalyticsScript());
        modelAndView.addObject("currentUsersEmail", authenticationService.getCurrentUsersEmail());
        modelAndView.addObject("mobileClient", DeviceUtils.getCurrentDevice(request).isMobile() || DeviceUtils.getCurrentDevice(request).isTablet());
    }

}