package org.hbrs.se1.ws23.uebung3.view;

import org.hbrs.se1.ws23.uebung3.Member;

import java.util.List;

public class MemberView {

    public void  dump(List<Member> memberList) {
        for (Member member : memberList) {
            System.out.println(member.toString());
        }
    }

}
