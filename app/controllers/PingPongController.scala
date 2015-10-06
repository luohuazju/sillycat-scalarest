package controllers

import play.api.mvc.{Action, Controller}
import com.wordnik.swagger.annotations.{Api,ApiModel,ApiModelProperty,ApiOperation,ApiParam,ApiResponse,ApiResponses}



/**
 * Created by carl on 10/5/15.
 */

@Api(value = "/api/v1", description = "Operations with Classifier")
object PingPongController extends Controller{

  @ApiOperation(value = "Pings",
    notes = "Returns pong",
    response = classOf[String],
    httpMethod = "GET",
    produces = "text",
    position = 1)
  @ApiResponses(Array(
    new ApiResponse(code = 200, message = "Successful ping", response = classOf[String])
  )
  )
  def ping = Action {
    Ok("pong")
  }

}
