package org.jaudiotagger.audio.dff;

import org.jaudiotagger.audio.generic.Utils;

import java.nio.ByteBuffer;

/**
 * DSD Chunk
 */
public class SndChunk {
    public static final int CHUNKSIZE_LENGTH = 0;
    public static final int SIGNATURE_LENGTH = 4;

    public static final int SND_HEADER_LENGTH = SIGNATURE_LENGTH + CHUNKSIZE_LENGTH;

    private SndChunk(ByteBuffer dataBuffer) {

    }

    public static SndChunk readChunk(ByteBuffer dataBuffer) {
        String type = Utils.readFourBytesAsChars(dataBuffer);
        if (DffChunkType.SND.getCode().equals(type)) {
            return new SndChunk(dataBuffer);
        }
        return null;
    }

    @Override
    public String toString() {
        return DffChunkType.SND.getCode();
    }
}
