package com.example.demo.dto.validOrder;

import javax.validation.GroupSequence;

@GroupSequence({ValidGroup1.class, ValidGroup2.class}) // この順番になる　→　アノテーションにgroupsを付けて指定 → @Valitatedにこのクラスを付ける
public interface GroupOrder {
	
}
