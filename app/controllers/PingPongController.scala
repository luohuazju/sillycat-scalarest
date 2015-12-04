package controllers

import play.api.mvc.{Action, Controller}
import com.wordnik.swagger.annotations.{Api,ApiModel,ApiModelProperty,ApiOperation,ApiParam,ApiResponse,ApiResponses}


@Api(value = "/api/v1/ping", description = "Operations with PingPong")
object PingPongController extends Controller{

  @ApiOperation(value = "Pings",
    notes = "Returns pong",
    response = classOf[String],
    httpMethod = "GET",
    produces = "text",
    position = 1)
  @ApiResponses(Array(
    new ApiResponse(code = 200, message = "Successful ping")
  )
  )
  def ping = Action {
    Ok("pong")
  }

}
