package chap05;

/**
 * Created by Gavin.Stevenson on 2017/3/11.
 */
public class Link {
    public  int iData;
    public double dData;
    public Link next;

    public Link(int iData, double dData) {
        this.iData = iData;
        this.dData = dData;
    }
    public void disply()
    {
        System.out.print("{"+iData+" , "+dData+"}");
    }
}
