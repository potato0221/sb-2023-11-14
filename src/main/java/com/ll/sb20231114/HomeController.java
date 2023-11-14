package com.ll.sb20231114;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
