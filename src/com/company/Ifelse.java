package com.company;

public class Ifelse {
    public void ChekIfelse(){
        String SerialId = "3C49C78183BAA3CA50AAC762C1CE82BD";
        String SignStauts = "2";
        String fromErp = "2";
        String out = CheckString(fromErp, SignStauts, SerialId);
        if ("2".equals(SignStauts)){
            System.out.println(out);
        }
        else if ("1".equals(fromErp)){
            if("1".equals(SignStauts)){
                System.out.println(out);
            }
            else {
                System.out.println(out);
            }
        }
        else if ("1".equals(SignStauts)){
            System.out.println(out);
        }
        else {
            System.out.println(out);
        }
    }

    public String CheckString(String fromErp, String SignStauts, String SerialId){
        String ret = SerialId + ":" + SignStauts;
        if (fromErp == "1"){
            ret += "||BZ";
        }
        else {
            ret += "||SR";
        }
        return ret;
    }
}
