package tcp_bridge;

import java.io.*;
import java.net.*;

import data_types.Base_data;

// https://www.tutorialspoint.com/java/java_serialization.htm
// how to serialize/ deserialize

public class Tcp_bridge 
{
	// Close existing connection
	protected boolean close_connection()
	{
		try
		{
			m_socket.close();
			return true;
		}
		catch(IOException e)
		{
			return false;
		}
	}
	
	// Open a new connection
	protected boolean open_connection(String host, int port)
	{
		if(!close_connection())
			return false;
		
		try
		{
			m_socket = new Socket(host, port);
			return true;
		}
		catch(UnknownHostException e)
		{
			System.out.print("bad host name");
			return false;
		}
		catch(IOException e)
		{
			System.out.print("couldn't get I/O connection");
			return false;
		}
	}
	
	// Sends a constructed data message
	public void Send_data(Base_data data)
	{
		String message = serialize(data);
		
		// Check if connected
		// Looks like we need to use streams
		// use m_socket to send
	}
	
	// returns if we have a active connection
	public boolean Is_connected()
	{
		return m_socket.isConnected();
	}
	
	// Takes in a data class and returns it serialized
	private String serialize(Base_data data)
	{
		
		return "serialized output";
	}
	
	// Takes in a serialized data class and returns the corresponding type
	private Base_data deserialize(String data)
	{
		Base_data deserialized_data = null;
		return deserialized_data;
	}
	
	
	protected Socket m_socket;
}
