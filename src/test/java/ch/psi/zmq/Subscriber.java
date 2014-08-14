/**
 * 
 * Copyright 2013 Paul Scherrer Institute. All rights reserved.
 * 
 * This code is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 * 
 * This code is distributed in the hope that it will be useful, but without any
 * warranty; without even the implied warranty of merchantability or fitness for
 * a particular purpose. See the GNU Lesser General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this code. If not, see <http://www.gnu.org/licenses/>.
 * 
 */

package ch.psi.zmq;

import org.zeromq.ZMQ;

/**
 * Example ZeroMQ subscriber
 * @author ebner
 *
 */
public class Subscriber {

	public static void main(String[] args) {
		ZMQ.Context context = ZMQ.context(1);
		ZMQ.Socket socket = context.socket(ZMQ.SUB);
		
		socket.subscribe("".getBytes()); // Equivalent to: socket.setsockopt(zmq.SUBSCRIBE, "");

		socket.connect("tcp://localhost:8080");

		while(true){
			Object message= socket.recv();
			System.out.println(message);
		}
	}

}
