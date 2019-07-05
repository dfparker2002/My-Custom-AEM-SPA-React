package com.adobe.aem.guides.wkndevents.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class,
    resourceType = CustomModel.RESOURCE_TYPE,
    adapters = {CustomModel.class, ComponentExporter.class},
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME,
    extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class CustomModel implements ComponentExporter {

  protected static final String RESOURCE_TYPE = "wknd-events/components/content/custom";

  @ValueMapValue(name = "customTitle")
  private String customTitle;

  @Nullable
  public String getCustomTitle() {
    return customTitle;
  }


  @Nonnull
  @Override
  public String getExportedType() {
    return RESOURCE_TYPE;
  }
}
