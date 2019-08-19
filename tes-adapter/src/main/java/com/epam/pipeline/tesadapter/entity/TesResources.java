package com.epam.pipeline.tesadapter.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@ApiModel(description = "Resources describes the resources requested by a task.")
@Data
public class TesResources {
    @ApiModelProperty(value = "Requested number of CPUs")
    @JsonProperty("cpu_cores")
    private Long cpuCores = null;

    @ApiModelProperty(value = "Is the task allowed to run on preemptible compute instances (e.g. AWS Spot)?")
    @JsonProperty("preemptible")
    private Boolean preemptible = null;

    @ApiModelProperty(value = "Requested RAM required in gigabytes (GB)")
    @JsonProperty("ram_gb")
    private Double ramGb = null;

    @ApiModelProperty(value = "Requested disk size in gigabytes (GB)")
    @JsonProperty("disk_gb")
    private Double diskGb = null;

    @ApiModelProperty(value = "Request that the task be run in these compute zones.")
    @JsonProperty("zones")
    @Valid
    private List<String> zones = null;

    public TesResources cpuCores(Long cpuCores) {
        this.cpuCores = cpuCores;
        return this;
    }

    public TesResources preemptible(Boolean preemptible) {
        this.preemptible = preemptible;
        return this;
    }

    public TesResources ramGb(Double ramGb) {
        this.ramGb = ramGb;
        return this;
    }

    public TesResources diskGb(Double diskGb) {
        this.diskGb = diskGb;
        return this;
    }

    public TesResources zones(List<String> zones) {
        this.zones = zones;
        return this;
    }

    public TesResources addZonesItem(String zonesItem) {
        if (this.zones == null) {
            this.zones = new ArrayList<String>();
        }
        this.zones.add(zonesItem);
        return this;
    }
}
