package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!값");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(Model model, @RequestParam("name") String name) {
        model.addAttribute("data", name);
        return "hello-templates";
    }

    @GetMapping("hello-mvc2")
    public String helloMvc2(Model model, @RequestParam(value = "name", required = false) String name) {
        model.addAttribute("data", name);
        return "hello-templates";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(Model model, @RequestParam("name") String name) {
        // @ResponseBody로 인해 string을 그대로 반환
        return "string 그대로 ~~~ " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(Model model, @RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        // @ResponseBody로 인해 객체를 json 형식으로 반환
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }



}
