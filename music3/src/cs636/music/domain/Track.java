package cs636.music.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
@Table(name="TRACK",  uniqueConstraints =
	@UniqueConstraint(columnNames={"PRODUCT_ID", "TRACK_NUMBER"}))
@Cacheable

public class Track implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TRACK_ID")
	private long trackId;

	@Column(name="SAMPLE_FILENAME", length=100)
	private String sampleFilename;

	@Column(nullable=false, length=100)
	private String title;

	@Column(name="TRACK_NUMBER", nullable=false)
	private int trackNumber;

    @ManyToOne
	@JoinColumn(name="PRODUCT_ID", nullable=false)
	private Product product;

    public Track() {
    }

	public long getTrackId() {
		return this.trackId;
	}

	public void setTrackId(long trackId) {
		this.trackId = trackId;
	}

	public String getSampleFilename() {
		return this.sampleFilename;
	}

	public void setSampleFilename(String sampleFilename) {
		this.sampleFilename = sampleFilename;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getTrackNumber() {
		return trackNumber;
	}

	public void setTrackNumber(int trackNumber) {
		this.trackNumber = trackNumber;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	public String sampleFilenamePath() {
		return product.getCode() + "/" + sampleFilename;
	}

	
}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  