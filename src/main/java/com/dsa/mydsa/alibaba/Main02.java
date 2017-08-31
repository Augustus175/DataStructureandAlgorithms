package com.dsa.mydsa.alibaba;

/**
 * Created by zhangzhibo-dell on 17-8-25.
 */

import java.util.*;

class persion {
    final String id;
    final String tec;

    public persion(String id, String tec) {
        this.id = id;
        this.tec = tec;
    }

    int num = 0;
    int tid = 0;

    public boolean isFull() {
        if (num >= 2) {
            return true;
        } else {
            return false;
        }
    }

    public void addNum(int num) {
        this.num++;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getNum() {
        return num;
    }

    public int getTid() {
        return tid;
    }
}

class team {
    final int tid;
    String id;
    String java;
    String data;
    String web;
    String dm;
    public int num = 0;

    public void addper() {
        num++;
    }

    public boolean isFullteam() {
        if (num >= 3) {
            return true;
        } else {
            return false;
        }
    }

    public int getNum() {
        return num;
    }

    public team(int tid) {
        this.tid = tid;
    }

    public int getTid() {
        return tid;
    }

    public String getId() {
        return id;
    }

    public String getJava() {
        return java;
    }

    public String getData() {
        return data;
    }

    public String getWeb() {
        return web;
    }

    public String getDm() {
        return dm;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setJava(String java) {
        this.java = java;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public void setDm(String dm) {
        this.dm = dm;
    }
}

public class Main02 {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^
     **/
    static String[] fsd_team(String[] staff_info) {
        String[] ids = new String[staff_info.length];
        List<team> teams = new ArrayList<>();
        HashMap<String, String> table = new HashMap<>();
        persion[] pers = new persion[staff_info.length];
        int ti = 0;
        for (int i = 0; i < staff_info.length; i++) {
            String sid = staff_info[i].split(",")[0];
            String stec = staff_info[i].split(",")[1];
            pers[i] = new persion(sid, stec);
            if (stec.equals("java")) {
                teams.add(new team(ti));
                teams.get(i).setJava(sid);
                teams.get(i).addper();

                ti++;
            }
//            ids[i] = staff_info[i].split(" ")[0];
//            table.put(ids[i],staff_info[i].split(" ")[1]);
        }
        for (int i = 0; i < teams.size(); i++) {
            team t = teams.get(i);
            if (t.getWeb() == null) {
                for (int j = 0; j < pers.length; j++) {
                    persion per = pers[i];
                    if (!per.isFull() && per.tec.equals("web")) {
                        t.setWeb(per.id);
                        t.addper();
                    }
                }
            }
            if (!t.isFullteam()) {
                if (t.getData() == null) {
                    for (int j = 0; j < pers.length; j++) {
                        if (pers[j].tec.equals("data")) {
                            if (!t.isFullteam()) {
                                t.setData(pers[i].id);
                            }
                        }
                    }
                }
                for (int j = 0; j < pers.length; j++) {

                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] res;

        int _staff_info_size = 0;
        _staff_info_size = Integer.parseInt(in.nextLine().trim());
        String[] _staff_info = new String[_staff_info_size];
        String _staff_info_item;
        for (int _staff_info_i = 0; _staff_info_i < _staff_info_size; _staff_info_i++) {
            try {
                _staff_info_item = in.nextLine();
            } catch (Exception e) {
                _staff_info_item = null;
            }
            _staff_info[_staff_info_i] = _staff_info_item;
        }

        res = fsd_team(_staff_info);
        for (int res_i = 0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }

    }
}
