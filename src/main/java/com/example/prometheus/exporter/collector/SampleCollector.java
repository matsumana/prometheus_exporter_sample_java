package com.example.prometheus.exporter.collector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.prometheus.client.Collector;
import io.prometheus.client.Collector.MetricFamilySamples.Sample;

public class SampleCollector extends Collector {

    private static final String NAMESPACE = "sample_exporter";

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public List<MetricFamilySamples> collect() {

        log.debug("SampleCollector#collect");

        List<MetricFamilySamples> ret = new ArrayList<>();

        {
            // no labels
            List<String> labelNames = Collections.emptyList();
            List<String> labelValues = Collections.emptyList();

            // FIXME
            double metric = 1;

            List<MetricFamilySamples.Sample> samples = Collections.singletonList(
                    new Sample(NAMESPACE + "_hoge", labelNames, labelValues, metric));
            ret.add(new MetricFamilySamples(NAMESPACE + "_hoge", Type.GAUGE, "", samples));
        }

        {
            // labels
            List<String> labelNames = new ArrayList<>();
            labelNames.add("label1");
            labelNames.add("label2");
            List<String> labelValues = new ArrayList<>();
            labelValues.add("aaa");
            labelValues.add("bbb");

            // FIXME
            double metric = 1;

            List<MetricFamilySamples.Sample> samples = Collections.singletonList(
                    new Sample(NAMESPACE + "_fuga", labelNames, labelValues, metric));
            ret.add(new MetricFamilySamples(NAMESPACE + "_fuga", Type.GAUGE, "", samples));
        }

        return ret;
    }
}
