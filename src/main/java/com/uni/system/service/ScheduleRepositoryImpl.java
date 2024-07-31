package com.uni.system.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.uni.system.repository.interfaces.ScheduleRepository;
import com.uni.system.repository.model.NoticeList;
import com.uni.system.repository.model.Schedule;
import com.uni.system.utils.DBUtil;

import lombok.Data;
@Data
public class ScheduleRepositoryImpl implements ScheduleRepository {
	
	private static final String SELECT_ALL_SCHEDULE = " SELECT * FROM schedule_tb ORDER BY id DESC LIMIT 6 OFFSET 0 " ;
			 ;

	@Override
	public List<Schedule> selectAllscheduleTable() {
		List<Schedule> scheduleList = new ArrayList<Schedule>();
		try(Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_SCHEDULE)){
			try (ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					Schedule scheduleLists = Schedule.builder()
							.id(rs.getInt("id"))
							.staffId(rs.getInt("staff_id"))
							.startDay(rs.getDate("start_day"))
							.endDay(rs.getDate("end_day"))
							.information(rs.getString("information"))
							.build();
						scheduleList.add(scheduleLists);
							}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return scheduleList;
	}


}
