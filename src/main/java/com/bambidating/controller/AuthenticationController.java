package com.bambidating.controller;

import com.bambidating.controller.Utils.ControllersMapping;
import com.bambidating.controller.Utils.PagesName;
import com.bambidating.model.requestModel.AuthenticationModel;
import com.bambidating.model.requestModel.RegistrationModel;
import com.bambidating.model.requestModel.VkAuthenticationModel;
import com.bambidating.model.responseModel.BaseResponse;
import com.bambidating.service.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping(ControllersMapping.AUTHENTICATION)
public class AuthenticationController {

  private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(method = RequestMethod.GET)
    public String showAuthenticationPage() {
        return PagesName.AUTHENTICATION.value();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody BaseResponse login(@Valid AuthenticationModel authenticationModel, BindingResult result) {
      LOGGER.info("info logging");
      return authenticationService.login(authenticationModel, result);
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public @ResponseBody BaseResponse registration(@Valid RegistrationModel registrationModel, BindingResult result) {
      LOGGER.info("info logging");
        return authenticationService.registration(registrationModel, result);
    }

    @RequestMapping(value = "/online", method = RequestMethod.PUT)
    public @ResponseBody BaseResponse checkOnline() {
        return authenticationService.online();
    }

}
