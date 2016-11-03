package se.enbohms.fibonacci.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/fibonacci/{number}")
public class FibonacciEndpoint {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFobonacciFor(@PathParam("number") int number) {
		if (number < 50) {
			return Response.ok("Fibonacci for " + number + " is " + fib(number)).build();
		} else {
			return Response.status(403).entity("Too large number, can't calculate this").build();
		}
	}

	private long fib(int n) {
		if (n <= 1) {
			return n;
		} else {
			return fib(n - 1) + fib(n - 2);
		}
	}
}
