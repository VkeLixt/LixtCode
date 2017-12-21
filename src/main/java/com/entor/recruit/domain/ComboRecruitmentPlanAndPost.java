package com.entor.recruit.domain;

import java.io.Serializable;

public class ComboRecruitmentPlanAndPost implements Serializable {

	
	private static final long serialVersionUID = 8765629358003909270L;

	private Post post;
	private RecruitmentPlan recruitmentPlan;
	
	public ComboRecruitmentPlanAndPost(){
		
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public RecruitmentPlan getRecruitmentPlan() {
		return recruitmentPlan;
	}

	public void setRecruitmentPlan(RecruitmentPlan recruitmentPlan) {
		this.recruitmentPlan = recruitmentPlan;
	}
	
	
	
	
}
