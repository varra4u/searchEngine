package com.search.spring.web.controllers;

import org.h2.tools.Server;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.SQLException;

@Component
public class H2ServerStarter {

	@PostConstruct
    public void startH2TcpServer() throws SQLException
	{
         Server.createTcpServer("-tcpPort", "9092", "-tcpDaemon").start();
    }
}