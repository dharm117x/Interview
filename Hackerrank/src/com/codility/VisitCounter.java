package com.codility;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class UserStatus {
	Optional<Long> vistCount;

	public UserStatus() {
	}

	public UserStatus(Optional<Long> vistCount) {
		this.vistCount = vistCount;
	}

	public Optional<Long> getVistCount() {
		return vistCount;
	}

	public void setVistCount(Optional<Long> vistCount) {
		this.vistCount = vistCount;
	}

	@Override
	public String toString() {
		return "UserStatus [vistCount=" + vistCount + "]";
	}

}

public class VisitCounter {

	public static void main(String[] args) {

		Map<String, UserStatus> visit = new HashMap<>();
		visit.put("1", new UserStatus(Optional.of(10L)));
		visit.put("2", new UserStatus(Optional.of(20L)));

		Map<String, UserStatus> visit1 = new HashMap<>();
		visit1.put("1", new UserStatus(Optional.of(90L)));
		visit1.put("2", new UserStatus(Optional.of(80L)));

		Map<String, UserStatus> visit2 = new HashMap<>();
		visit2.put("1", new UserStatus(Optional.of(10L)));
		visit2.put("2", new UserStatus(Optional.of(10L)));

		Map<String, UserStatus> map[] = new HashMap[3];
		map[0] = visit;
		map[1] = visit1;
		map[2] = visit2;
		

		System.out.println(count(map));
	}

	public static Map<Long, Long> count1(Map<String, UserStatus>... array) {
		Map<Long, Long> res = new HashMap<>();
		return res;
		
	
	}
	public static Map<Long, Long> count(Map<String, UserStatus>... array) {

		Map<Long, Long> res = new HashMap<>();
		for (Map<String, UserStatus> map : array) {
			map.entrySet().forEach(m -> {
				Long key = Long.parseLong(m.getKey());
				Long val = m.getValue().getVistCount().get();
				System.out.println(key+"--"+val);
				
				if (!res.containsKey(key)) {
					res.put(key, val);
				} else {
					res.put(key, Long.sum(res.get(key) , val));
				}
			});
		}

		return res;
	}
}
