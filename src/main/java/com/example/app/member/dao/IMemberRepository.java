package com.example.app.member.dao;


import java.util.List;


import com.example.app.member.model.Member;
  
public interface IMemberRepository { 
	void insertMember(Member member);
	 Member selectMember(String userid);
	 List<Member> selectAllMembers();
	 void updateMember(Member member); 
	 void deleteMember (Member member); 
	 String getPassword(String userid);
}
  
 