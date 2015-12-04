import javax.inject.Inject

import play.api.http.HttpFilters
import play.filters.cors.CORSFilter

/**
 * Created by carl on 10/6/15.
 */
class Filters @Inject() (corsFilter: CORSFilter) extends HttpFilters {
  def filters = Seq(corsFilter)
}
