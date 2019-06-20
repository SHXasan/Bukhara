import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Soxranit {
    public String name;
    public int number;
    public ArrayList<String> konList = new ArrayList<String>();
    public String kon;
    public String RemDel;
    public int ind = 0;
    public int gitid = 2;
    Scanner in = new Scanner(System.in);

    public void proverkaImeni()
    {
        Scanner in = new Scanner(System.in);
        for (; ;) {

            System.out.println("Vvedite imya : ");
            name = in.nextLine();
            if (name.length() != 0) {
                proverkaNomera();
                break;
            }
        }

    }


    public void proverkaNomera() {

        Scanner in = new Scanner(System.in);
        for (; ; ) {

            try {
                System.out.println("\nVvedite nomer ");
                System.out.print("+ ");
                number = in.nextInt();

                if (kon != null) {
                    ind++;
                    kon = (ind + " " + name + " " + number);
                    saveKontakt(kon);
                    break;
                } else {
                    ind++;
                    kon = (ind + " " + name + " " + number);
                    saveKontakt(kon);
                    break;
                }
            } catch (Exception e) {
                in.next();
            }
        }

    }
    Zapis zp = new Zapis();
    public void saveKontakt(String kon) {

        //konList = new ArrayList<String>();
        this.kon = kon;
        konList.add(this.kon);
        System.out.println("Ok, kontakt saved");
        zp.Zapis(this.kon);
    }

    public void KonPoisk()
    {

        Zamena search = new Zamena();
        //Scanner in  = new Scanner(System.in);
       // String RemDel = "";
        System.out.println("Введите имя или номер контакта");
        String seakon = in.next();
        String yesno = "";
        int k;
        for (k = 0; k < konList.size(); k++)
        {
            if (konList.get(k).contains(seakon))
            {
                System.out.println("  \" Yes kontakt \" " + konList.get(k));
                RemDel = konList.get(k);
                yesno = "yes";

                for(;;) {
                    System.out.println("1-изменить 2-удалить 3-глав. меню");
                    int u = in.nextInt();
                    if (u == 3) {
                        System.out.println("Выход в меню");
                        break;
                    }
                    switch (u) {
                        case 1:
                            SetKon();
                            break;
                        case 2:
                            RemKon();
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        if (!yesno.equals("yes"))
        {
            System.out.println("No kontakt");
        }
    }

    public  void printinfo()
    {
        try {
            if(konList.size() == 0)
            {
                System.out.println("Список контактов пуст Sorry ))");
            }
            for (int i = 0; i < konList.size(); i++)
            {
                System.out.println(konList.get(i));
                //System.out.println(name + " , +" + number);
            }
        }catch(Exception e)
        {
            System.out.println("Список контактов пуст Sorry");
        }
    }
    public void RemKon()
    {
        konList.remove(RemDel);
        System.out.println("Контакт " + RemDel + " удален ");
    }

    public void SetKon()
    {
        System.out.println("Введите новое имя : ");
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        konList.set(konList.indexOf(RemDel),s);
    }

}



public class Prosto {
    public static void main(String[] args) {

        Soxranit sxr = new Soxranit();
        Zamena zm = new Zamena();
        Scanner in = new Scanner(System.in);
        int k = 0;
            for (; ; ) {
                System.out.println("1-добавить 2-поиск 3-инфо 4-Выход");
                try {
                    k = in.nextInt();

                    //System.out.println("Пожалуйста выберите один из пунктов");
                    if (k == 5) {
                        System.out.println("Poka poka");
                        break;
                    }


                    switch (k) {
                        case 1:
                            sxr.proverkaImeni();
                            break;
                        case 2:
                            sxr.KonPoisk();
                            break;
                        case 3:
                            sxr.printinfo();
                            //zm.zamenaKon();
                            break;
                        default:
                            System.out.println("Выберите один из пунктов");
                            break;
                    }
                }catch(Exception e)
                {
                    System.out.println("Пожалуйста выберите один из пунктов");
                    in.next();
                }
             }
    }
}