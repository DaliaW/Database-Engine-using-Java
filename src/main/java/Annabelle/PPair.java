package Annabelle;

import java.io.Serializable;

public class PPair implements Serializable{
    Object a;
    Object b;
    public PPair(Object a,Object b) {
        this.a=a;
        this.b=b;
    }
    @Override
    public String toString() {
        return"<"+ a.toString()+","+b.toString()+">";
    }

    public void setA(Object a) {
        this.a = a;
    }

    public void setB(Object b) {
        this.b = b;
    }
}
