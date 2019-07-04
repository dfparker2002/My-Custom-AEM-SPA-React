package com.adobe.aem.guides.wkndevents.core.models;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;

@Model(adaptables = SlingHttpServletRequest.class, adapters = {
    ComponentExporter.class}, resourceType = WeatherModel.RESOURCE_TYPE)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class WeatherModel implements ComponentExporter {

  static final String RESOURCE_TYPE = "wknd-events/components/content/weather";

  /**
   * Name of the resource property that will store the city to display the weather from.
   *
   * @since com.adobe.cq.sample.spa.commons.impl.models 1.0.0
   */
  private String PN_CITY = "city";

  /**
   * Name of the resource property that will store the api key of the Open Weather service
   *
   * @since com.adobe.cq.sample.spa.commons.impl.models 1.0.0
   */
  private String PN_API_KEY = "apiKey";

  @ScriptVariable
  private ValueMap properties;

  /**
   * Returns the value for the image's {@code title} attribute, if one was set.
   *
   * @return the value for the image's {@code title} attribute, if one was set, or {@code null}
   * @since com.adobe.cq.sample.spa.commons.impl.models 1.0.0
   */
  @Nullable
  public String getCity() {
    return properties.get(PN_CITY, String.class);
  }

  /**
   * Returns the value for the image's {@code title} attribute, if one was set.
   *
   * @return the value for the image's {@code title} attribute, if one was set, or {@code null}
   * @since com.adobe.cq.sample.spa.commons.impl.models 1.0.0
   */
  @Nullable
  public String getApiKey() {
    return properties.get(PN_API_KEY, String.class);
  }

  /**
   * @see ComponentExporter#getExportedType()
   * @since com.adobe.cq.sample.spa.commons.impl.models 1.0.0
   */
  @Nonnull
  @Override
  public String getExportedType() {
    return RESOURCE_TYPE;
  }

}

