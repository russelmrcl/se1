package org.hbrs.se1.ws23.uebung03.view;

import org.hbrs.se1.ws23.uebung03.Member;

import java.util.List;

public class MemberView {

    public void  dump(List<Member> memberList) {
        for (Member member : memberList) {
            System.out.println(member.toString());
        }
    }
}
