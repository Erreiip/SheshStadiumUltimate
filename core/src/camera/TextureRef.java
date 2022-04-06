package camera;

public class TextureRef {
    
    private String ref;
    private Integer frame;
    private long timestamp;

    public TextureRef(String ref) {

        this.ref = ref;
        this.timestamp = System.nanoTime();
    }

    public String getRef() {

        this.timestamp = System.nanoTime();
        return this.ref;
    }

    public Integer getFrame() {

        return this.frame;
    }

    public long getTimestamp() {

        return this.timestamp;
    }

    public boolean equals(TextureRef tRef) {

        return this.ref.equals(tRef.ref) && this.frame.equals(tRef.frame);
    }

    public boolean equals(String id, Integer frame) {

        return this.ref.equals(id) && this.frame.equals(frame);
    }
}