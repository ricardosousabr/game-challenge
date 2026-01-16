	package com.gamechallenge.api.game_challenge.entity;
	
	public enum UserStatus {
		INACTIVE("inactive"),
		ACTIVE("active");
		
		private final String status;
		
		UserStatus(String status){
			this.status = status;
		}
		
		public String getStatus() {
			return status;
		}
	}
