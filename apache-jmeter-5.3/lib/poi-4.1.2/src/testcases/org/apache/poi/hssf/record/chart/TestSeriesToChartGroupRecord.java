/* ====================================================================
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
==================================================================== */

package org.apache.poi.hssf.record.chart;


import static org.apache.poi.hssf.record.TestcaseRecordInputStream.confirmRecordEncoding;
import static org.junit.Assert.assertEquals;

import org.apache.poi.hssf.record.TestcaseRecordInputStream;
import org.junit.Test;

/**
 * Tests the serialization and deserialization of the SeriesToChartGroupRecord
 * class works correctly.  Test data taken directly from a real
 * Excel file.
 */
public final class TestSeriesToChartGroupRecord {
    byte[] data = new byte[] {
	(byte)0x0, (byte)0x0
    };

    @Test
    public void testLoad() {
        SeriesToChartGroupRecord record = new SeriesToChartGroupRecord(TestcaseRecordInputStream.create(0x1045, data));
        assertEquals( 0x0, record.getChartGroupIndex());

        assertEquals( 0x6, record.getRecordSize() );
    }

    @SuppressWarnings("squid:S2699")
    @Test
    public void testStore() {
        SeriesToChartGroupRecord record = new SeriesToChartGroupRecord();
        record.setChartGroupIndex( (short)0x0 );

        byte [] recordBytes = record.serialize();
        confirmRecordEncoding(SeriesToChartGroupRecord.sid, data, recordBytes);
    }
}
