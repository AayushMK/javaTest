package com.smartdatasolutions.test.impl;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberExporter;
import com.smartdatasolutions.test.MemberFileConverter;
import com.smartdatasolutions.test.MemberImporter;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;



public class Main extends MemberFileConverter {

	@Override
	protected MemberExporter getMemberExporter( ) {
		// TODO
		return new MemberExporterImpl(){
			
		};
	}

	@Override
	protected MemberImporter getMemberImporter( ) {

		return new MemberImporterImpl();
	}

	@Override
	protected List< Member > getNonDuplicateMembers( List< Member > membersFromFile ) {
		// TODO
		List<Member> newList = new ArrayList<>();
		boolean flag = false;
		for(Member m : membersFromFile){
			for (Member nm: newList){
				if(m.getId().equals(nm.getId())){
					flag = true;
				}
			}
			if(!flag){
				newList.add(m);
			}else{
				flag = false;
			}
		}
		return newList;
	}

	@Override
	protected Map< String, List< Member >> splitMembersByState( List< Member > validMembers ) {
		// TODO
		System.out.println("Split members by state");
		return null;
	}

	public static void main( String[] args ) {
		Main main = new Main();
		MemberImporter memImp = main.getMemberImporter();
		File inputFile = new File("Members.txt");
		List<Member> membersFromFile;
		List<Member> validMembers;
		try {
			membersFromFile = memImp.importMembers(inputFile);
			validMembers = main.getNonDuplicateMembers(membersFromFile);
			main.splitMembersByState(validMembers);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//TODO
	}

}
