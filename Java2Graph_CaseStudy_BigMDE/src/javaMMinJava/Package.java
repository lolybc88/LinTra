package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class Package extends NamedElement implements Serializable,
		IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	AbstractTypeDeclaration[] ownedElements;
	Boolean ownedElementsIsComposed = true;

	Model model;
	Boolean modelIsComposed = false;

	Package[] ownedPackages;
	Boolean ownedPackagesIsComposed = true;

	Package package_;
	Boolean packageIsComposed = false;

	PackageAccess[] usagesInPackageAccess;
	Boolean usagesInPackageAccessIsComposed = false;

	public Package() {
	}

	public Package(String id, String name, Boolean proxy, Comment[] comments,
			CompilationUnit originalCompilationUnit,
			ClassFile originalClassFile, ImportDeclaration[] usagesInImports,
			AbstractTypeDeclaration[] ownedElements, Model model,
			Package[] ownedPackages, Package package_,
			PackageAccess[] usagesInPackageAccess) {

		super(name, proxy, comments, originalCompilationUnit,
				originalClassFile, usagesInImports);

		this.id = id;

		this.ownedElements = ownedElements;
		this.model = model;
		this.ownedPackages = ownedPackages;
		this.package_ = package_;
		this.usagesInPackageAccess = usagesInPackageAccess;
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

	public void setOwnedElements(AbstractTypeDeclaration[] ownedElements) {
		this.ownedElements = ownedElements;
	}

	public AbstractTypeDeclaration[] getOwnedElements() {
		return ownedElements;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public Model getModel() {
		return model;
	}

	public void setOwnedPackages(Package[] ownedPackages) {
		this.ownedPackages = ownedPackages;
	}

	public Package[] getOwnedPackages() {
		return ownedPackages;
	}

	public void setPackage(Package package_) {
		this.package_ = package_;
	}

	public Package getPackage() {
		return package_;
	}

	public void setUsagesInPackageAccess(PackageAccess[] usagesInPackageAccess) {
		this.usagesInPackageAccess = usagesInPackageAccess;
	}

	public PackageAccess[] getUsagesInPackageAccess() {
		return usagesInPackageAccess;
	}

}
