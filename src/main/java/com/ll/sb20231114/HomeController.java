package com.ll.sb20231114;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @GetMapping("/") // 이 주소를 따라갔을때 나오는 동작 이라는 명시
    @ResponseBody // 이 함수의 리턴 값을 웹에 전송 / 출력
    String showMain(){
        return "안녕하세요";
    }

    @GetMapping("/about")
    @ResponseBody
    String showAbout(){
        return "개발자 커뮤니티";
    }

    @GetMapping("/calc")
    @ResponseBody
    //실행 시 오류가 발생 (null을 넣을 수 없음)
    //실행이 정상적으로 되려면 ?a=10&b=20 형식의 파라미터 값을 넣어줘야함
    String showCalc(int a, int b){
        return "계산 결과 : %d".formatted(a+b);
    }

    @GetMapping("/calc2")
    @ResponseBody//null을 넣을 수 있어서 실행이 됨
    String showCalc2(Integer a, Integer b){
        return "계산기";
    }


    @GetMapping("/calc3")
    @ResponseBody
    String showCalc3(
            @RequestParam(defaultValue ="0") int a,
            @RequestParam(defaultValue ="0") int b
    ){
        return "계산결과 : %d".formatted(a+b);
    }

    @GetMapping("/calc4")
    @ResponseBody
    String showCalc4(
            @RequestParam(defaultValue ="0") double a,
            @RequestParam(defaultValue ="0") double b
    ){
        return "계산결과 : %f".formatted(a+b);
    }

    @GetMapping("/calc5")
    @ResponseBody
    String showCalc5(
            @RequestParam(defaultValue ="-") String a,
            @RequestParam(defaultValue ="-") String b
    ){
        return "계산결과 : %s".formatted(a+b);
    }

    @GetMapping("/calc6")
    @ResponseBody
    int showCalc6(
            int a, int b
    ){
        return a + b;
    }


    @GetMapping("/calc7")
    @ResponseBody
    boolean showCalc7(
            int a, int b
    ){
        return a>b;
    }

    @GetMapping("/calc8")
    @ResponseBody
    Person showCalc8(
            String name, int age
    ){
        return new Person(name,age);
    }

    @GetMapping("/calc9")
    @ResponseBody
    Person2 showCalc9(
            String name, int age
    ){
        return new Person2(name,age);
    }

    @GetMapping("/calc10")
    @ResponseBody
    Map<String, Object> showCalc10(
            String name, int age
    ){
        Map<String, Object> personMap=Map.of(
                "name", name,
                "age", age
        );

        return personMap;
    }

    @GetMapping("/calc11")
    @ResponseBody
    List<Person2> showCalc11(
            String name, int age
    ){
        List<Person2> persons=new ArrayList<>(){{
            add(new Person2(name,age));
            add(new Person2(name+"!",age+1));
            add(new Person2(name+"!!",age+2));
        }};

        return persons;
    }

    @GetMapping("/calc12")
    @ResponseBody
    int[] showCalc12(){
        int[] nums=new int[]{10,20,50};

        return nums;
    }
    @GetMapping("/calc14")
    @ResponseBody
    String showCalc14(){
        String html="";

        html+="<div>";
        html+="<input type=\"text\" placeholder=\"내용\">";
        html+="</div>";
        return html;
    }


    @GetMapping("/calc15")
    @ResponseBody
    String showCalc15(){
        StringBuilder sb=new StringBuilder();

        sb.append("<div>");
        sb.append("<input type=\"text\" placeholder=\"내용\">");
        sb.append("</div>");
        return sb.toString();
    }

    @GetMapping("/calc16")
    @ResponseBody
    String showCalc16(){
        String html="<div><input type=\"text\" placeholder=\"내용\"></div>";
        return html;
    }

    @GetMapping("/calc17")
    @ResponseBody
    String showCalc17(){
        String html= """
                <div>
                    <input type="text" placeholder="내용">
                </div>""";
        return html;
    }

    @GetMapping("/calc18")
    @ResponseBody
    String showCalc18(){
        String html= """
                <div>
                    <input type="text" placeholder="내용" value="반가워요">
                </div>""";
        return html;
    }

    @GetMapping("/calc19")
    @ResponseBody
    String showCalc19(@RequestParam(defaultValue = "") String subject, String content){
        String html= """
                <div>
                    <input type="subject" placeholder="제목" value="%s">
                </div>
                <div>
                    <input type="text" placeholder="내용" value="%s">
                </div>
                """.formatted(subject,content);
        return html;
    }
// 14~19번은 html에 관한 코드가 controller에 들어 있기 때문에 엄밀히 말하면 틀린 코드
    @GetMapping("/calc20")
    String showCalc20(){
        return "calc20";
    }

    @GetMapping("/calc21")
    String showCalc21(Model model){
        model.addAttribute("v1","안녕");
        model.addAttribute("v2","반가워");
        return "calc21";
    }
    int num=0;
    @GetMapping("/calc22")
    @ResponseBody
    int showCalc22(){
        num++;
        return num;
    }






}
@AllArgsConstructor
class Person{
    public String name;
    public int age;
}
@AllArgsConstructor
class Person2{
    @Getter
    private String name;
    @Getter
    private int age;
}
