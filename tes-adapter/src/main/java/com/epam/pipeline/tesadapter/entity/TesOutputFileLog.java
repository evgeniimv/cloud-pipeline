package com.epam.pipeline.tesadapter.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@ApiModel(description = "OutputFileLog describes a single output file. This describes file details " +
        "after the task has completed successfully, for logging purposes.")
@Data
public class TesOutputFileLog {
    @ApiModelProperty(value = "URL of the file in storage, e.g. s3://bucket/file.txt")
    @JsonProperty("url")
    private String url = null;

    @ApiModelProperty(value = "Path of the file inside the container. Must be an absolute path.")
    @JsonProperty("path")
    private String path = null;

    @ApiModelProperty(value = "Size of the file in bytes.")
    @JsonProperty("size_bytes")
    private String sizeBytes = null;

    public TesOutputFileLog url(String url) {
        this.url = url;
        return this;
    }

    public TesOutputFileLog path(String path) {
        this.path = path;
        return this;
    }

    public TesOutputFileLog sizeBytes(String sizeBytes) {
        this.sizeBytes = sizeBytes;
        return this;
    }
}
