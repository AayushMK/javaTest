package com.smartdatasolutions.test.impl;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberImporter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MemberImporterImpl implements MemberImporter {

	@Override
	public List< Member > importMembers( File inputFile ) throws Exception {

		/*
		 * Implement the missing logic
		 */
		List <Member> lmb = new ArrayList<>(); 
		try (BufferedReader br = new BufferedReader( new FileReader( inputFile ) )) {
			String line = br.readLine( );
			int x = 0;

			while ( line != null ) {
				// 
				x++;
				String[] details = line.split("\s{2,}");
				
				Member m = new Member();
				m.setId(details[0]);
				m.setFirstName(details[1]);
				m.setLastName(details[2]);
				m.setAddress(details[3]);
				if(details.length < 7){
					int indexLast = details[4].length() -1;

					int sIndexLast = indexLast -1;
					String c1 = String.valueOf(details[4].charAt(indexLast));
					String c2 = String.valueOf(details[4].charAt(sIndexLast));
					String state = c1 +c2;
					m.setCity(details[4].substring(0, indexLast - 2));
					m.setState(state);
					m.setZip(details[5]);
				
				}else{

					m.setCity(details[4]);
					m.setState(details[5]);
					m.setZip(details[6]);
					
				}
				lmb.add(m);
				line = br.readLine( );
			
		}
		}

		return lmb;
	}
	
	

}
