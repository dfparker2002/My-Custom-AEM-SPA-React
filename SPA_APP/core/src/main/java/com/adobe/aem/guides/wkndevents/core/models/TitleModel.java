package com.adobe.aem.guides.wkndevents.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.day.cq.wcm.api.Page;
import com.drew.lang.StringUtil;
import javax.annotation.Nonnull;
import javax.inject.Inject;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = SlingHttpServletRequest.class,
    resourceType = TitleModel.RESOURCE_TYPE,
    adapters = {TitleModel.class, ComponentExporter.class},
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME,
    extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class TitleModel implements ComponentExporter {
  static final String RESOURCE_TYPE = "wknd-events/components/content/title";

  @Inject
  private Page currentPage;

  @ValueMapValue(name = "jcr:title")
  private String title;

  @ValueMapValue
  private String linkURL;

  @ValueMapValue
  private String type;

  public String getLinkURL() {
    return linkURL;
  }

  public String getType() {
    return type;
  }

  public String getTitle() {
    return StringUtils.isNoneEmpty(title)? title : currentPage.getTitle();
  }

  @Nonnull
  @Override
  public String getExportedType() {
    return RESOURCE_TYPE;
  }
}
