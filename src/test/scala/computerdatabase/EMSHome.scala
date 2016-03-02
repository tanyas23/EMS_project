package computerdatabase

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class EMSHome extends Simulation {

  // your code starts here
  val ipAddress = System.getProperty("ipAddress")
  val ip = System.getProperty("ip")
  val port = Integer.parseInt(System.getProperty("port"))
  val httpConf = http.proxy(Proxy(ip, port))
  val scn = scenario("EMS Scenario")
    .exec(http("Home Page")
      .get(ipAddress + "/EmployeeApplication/home.htm"))
    .pause(10)
    .exec(http("request_add")
      .post(ipAddress + "/EmployeeApplication/add.htm")
      .formParam("""code""", """1""") // Note the triple double quotes: used in Scala for protecting a whole chain of characters (no need for backslash)
      .formParam("""name""", """a""")
      .formParam("""city""", """b"""))
    .pause(1)
    .exec(http("request_edit")
      .get(ipAddress + "/EmployeeApplication/edit.jsp?code=1&name=a&city=a"))
    .pause(1)
    .exec(http("request_edit submit")
      .post(ipAddress + "/EmployeeApplication/edit.htm")
      .formParam("""code""", """1""")
      .formParam("""name""", """b""")
      .formParam("""city""", """c"""))
    .pause(1)
    .exec(http("request_delete")
      .get(ipAddress + "/EmployeeApplication/delete.jsp?code=1"))
    .pause(10)
    .exec(http("request_delete submit")
      .post(ipAddress + "/EmployeeApplication/delete.htm")
      .formParam("""code""", """1"""))

  setUp(scn.inject(rampUsers(100) over (10 seconds))).assertions(
    global.successfulRequests.percent.greaterThan(10)).protocols(httpConf)
  //setUp(scn.inject(rampUsers(100) over (10 seconds)))
  //  setUp(scn.inject(atOnceUsers(10)))
  // your code ends here
}