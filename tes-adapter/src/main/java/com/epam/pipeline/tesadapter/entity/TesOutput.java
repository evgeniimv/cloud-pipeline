package com.epam.pipeline.tesadapter.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;


@ApiModel(description = "Output describes Task output files.")
@Data
public class TesOutput {
    @ApiModelProperty(value = "")
    @JsonProperty("name")
    private String name = null;

    @ApiModelProperty(value = "")
    @JsonProperty("description")
    private String description = null;

    @ApiModelProperty(value = "URL in long term storage, for example: s3://my-object-store/file1 " +
            "gs://my-bucket/file2 file:///path/to/my/file /path/to/my/file etc...")
    @JsonProperty("url")
    private String url = null;

    @ApiModelProperty(value = "Path of the file inside the container. Must be an absolute path.")
    @JsonProperty("path")
    private String path = null;

    @ApiModelProperty(value = "Type of the file, FILE or DIRECTORY")
    @JsonProperty("type")
    @Valid
    private TesFileType type = null;

    public TesOutput name(String name) {
        this.name = name;
        return this;
    }

    public TesOutput description(String description) {
        this.description = description;
        return this;
    }

    public TesOutput url(String url) {
        this.url = url;
        return this;
    }

    public TesOutput path(String path) {
        this.path = path;
        return this;
    }

    public TesOutput type(TesFileType type) {
        this.type = type;
        return this;
    }
}
