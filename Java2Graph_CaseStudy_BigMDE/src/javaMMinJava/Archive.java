package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class Archive extends NamedElement
		implements
			Serializable,
			IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	String originalFilePath;

	ClassFile classFiles;
	Boolean classFilesIsComposed = true;

	Manifest manifest;
	Boolean manifestIsComposed = true;

	public Archive() {
	}

	public Archive(String id, String name, Boolean proxy,
			String originalFilePath, Comment comments,
			CompilationUnit originalCompilationUnit,
			ClassFile originalClassFile, ImportDeclaration usagesInImports,
			ClassFile classFiles, Manifest manifest) {

		super(name, proxy, comments, originalCompilationUnit,
				originalClassFile, usagesInImports);

		this.id = id;

		this.originalFilePath = originalFilePath;

		this.classFiles = classFiles;
		this.manifest = manifest;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTrgId() {
		return trgId;
	}

	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public void setOriginalFilePath(String originalFilePath) {
		this.originalFilePath = originalFilePath;
	}

	public String getOriginalFilePath() {
		return originalFilePath;
	}

	public void setClassFiles(ClassFile classFiles) {
		this.classFiles = classFiles;
	}

	public ClassFile getClassFiles() {
		return classFiles;
	}

	public void setManifest(Manifest manifest) {
		this.manifest = manifest;
	}

	public Manifest getManifest() {
		return manifest;
	}

}
