package com.bambidating.controller;

import com.bambidating.controller.Utils.ControllersMapping;
import com.bambidating.controller.Utils.PagesName;
import com.bambidating.controller.Utils.HttpSession.UserSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(ControllersMapping.MAIN)
public class MainController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private UserSessionManager userSessionManager;

    @RequestMapping(method = RequestMethod.GET)
    public String showMainPage() {
      LOGGER.info("messfdf12 inn={} ldap={}");
      System.out.print("gfdgh111111");
        if (userSessionManager.isLogin())
        return PagesName.MAIN.value();
     return PagesName.AUTHENTICATION.value();
    }
}
