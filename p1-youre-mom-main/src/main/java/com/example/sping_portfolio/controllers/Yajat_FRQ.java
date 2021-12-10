package com.example.sping_portfolio;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Yajat_FRQ {

    String[] frq_list = { "Unit 2 Part A: Write a statement to create a LightSequence object gradShow that has the initial light sequence \"0101 0101 0101\".\n" +
            "Write the statement below.\n" +
            "a)\n" +
            "LightSequence gradShow = new LightSequence(\"0101 0101 0101\");\n", "Part B: Write a statement that will call the display method to display the light sequence for the gradShow object.\n" +
            "Write the statement below.\n" +
            "b)\n" +
            "\n" +
            "gradShow.display();\n", "Part C: Write a statement that will be used to update the gradShow light sequence to \"0011 0011 0011\".\n" +
            "Write the statement below.\n" +
            "\n" +
            "c)\n" +
            "gradShow.changeSequence(\"0011 0011 0011\");\n", "Part D: Write a code segment that will call the insertSegment method to insert the segment \"1111 1111\" in the current sequence for gradShow at index 4. The resulting sequence will be stored in the string resultSeq.\n" +
            "Write the code segment below.\n" +
            "\n" +
            "d)\n" +
            "String resultSeq = gradShow.insertSegment(\"1111 1111\", 4);\n", "Part E: Assume that the string oldSeq has been properly declared and initialized and contains the string segment. Write a code segment that will remove the first occurrence of segment from oldSeq and store it in the string newSeq. Consider the following examples.\n" +
            "If oldSeq is \"1100000111\" and segment is \"11\", then \"00000111\" should be stored in newSeq.\n" +
            "If oldSeq is \"0000011\" and segment is \"11\", then \"00000\" should be stored in newSeq.\n" +
            "If oldSeq is \"1100000111\" and segment is \"00\", then \"11000111\" should be stored in newSeq.\n" +
            "Write the code segment below. Your code segment should meet all specifications and\n" +
            "conform to the examples.\n" +
            "\n" +
            "e)\n" +
            "int start = oldSeq.indexOf(segment);\n" +
            "String newSeq = oldSeq.substring(0,start) + oldSeq.substring(start+segment.length());\n", "Part F: Two lights will be arranged on a two-dimensional plane. The vertical distance between the two lights is stored in the double variable a. The horizontal distance between the two lights is stored in the double variable b.The straight-line distance between the two lights is given by the formula .Write a code segment that prints the straight-line distance between the two lights according to the formula above.\n" +
            "\n" +
            "\n" +
            "f)\n" +
            "System.out.println(Math.sqrt(a*a + b*b));\n"};

    @GetMapping("/yajat_frq")
    public String FRQ(Model model) {
        model.addAttribute("frq_list", frq_list);

        return "yajat_frq";
    }}

//for testing
//    public static void main(String[] args) {
//        System.out.println(frq_list);
//    }
//}
