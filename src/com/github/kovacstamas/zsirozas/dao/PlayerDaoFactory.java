package com.github.kovacstamas.zsirozas.dao;

public class PlayerDaoFactory {

	public static PlayerDao getDao(PlayerDaoEnum daoEnum) {
		switch(daoEnum) {
			case CONSOLE:
				return new ConsolePlayerDao();
			default:
				return null;
		}
	}
}
