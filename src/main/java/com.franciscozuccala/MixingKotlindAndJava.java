package com.franciscozuccala;

public class MixingKotlindAndJava {
    MyClass myClass = new MyClass();


    private void usingMyClass(){
        myClass.aCommonFunction("Param");
    }


    public void a (Expr expr){
        if (expr instanceof  NotANumber){
            ((NotANumber) expr).toString();
        }
        if (expr instanceof  Sum){
            ((Sum) expr).getValue();
        }
        if (expr instanceof  Const){
            ((Const) expr).getNumber();
        }

    }
}
