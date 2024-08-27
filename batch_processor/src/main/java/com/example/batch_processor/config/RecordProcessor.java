package com.example.batch_processor.config;

import com.example.batch_processor.entity.Record;
import org.springframework.batch.item.ItemProcessor;

public class RecordProcessor implements ItemProcessor<Record,Record> {
    @Override
    public Record process(Record record) throws Exception {
        return record;
    }
}
