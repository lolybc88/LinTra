
		package javaMMinJava;
		
		import blackboard.IdentifiableElement;
		import java.io.Serializable;
	
		public  class CompilationUnit  extends NamedElement implements Serializable, IdentifiableElement {
			
			private static final long serialVersionUID = 1L;
			
			String id, trgId;
			
			
			String originalFilePath;
			
			
			Comment commentList; Boolean commentListIsComposed = false;
			
			ImportDeclaration imports; Boolean importsIsComposed = true;
			
			Package package; Boolean packageIsComposed = false;
			
			AbstractTypeDeclaration types; Boolean typesIsComposed = false;
			
			
			public CompilationUnit(){ }
			
			
			public CompilationUnit(
				String id,				
				String name,				Boolean proxy,				String originalFilePath
				,
				Comment comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile,				ImportDeclaration usagesInImports,				Comment commentList,				ImportDeclaration imports,				Package package,				AbstractTypeDeclaration types ){
				
				super(				name,				proxy				,
				comments
				,				originalCompilationUnit
				,				originalClassFile
				,				usagesInImports
);
				
				this.id = id;
				
				
				this.originalFilePath = originalFilePath ;
				
				this.commentList = commentList ;
				this.imports = imports ;
				this.package = package ;
				this.types = types ;
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
			
			
			
			public void setCommentList(Comment commentList) {
				this.commentList = commentList;
			}
				
			public Comment getCommentList() {
				return commentList;
			}
			
			public void setImports(ImportDeclaration imports) {
				this.imports = imports;
			}
				
			public ImportDeclaration getImports() {
				return imports;
			}
			
			public void setPackage(Package package) {
				this.package = package;
			}
				
			public Package getPackage() {
				return package;
			}
			
			public void setTypes(AbstractTypeDeclaration types) {
				this.types = types;
			}
				
			public AbstractTypeDeclaration getTypes() {
				return types;
			}
			
		}
	