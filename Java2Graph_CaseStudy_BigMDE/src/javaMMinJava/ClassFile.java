
		package javaMMinJava;
		
		import blackboard.IdentifiableElement;
		import java.io.Serializable;
	
		public  class ClassFile  extends NamedElement implements Serializable, IdentifiableElement {
			
			private static final long serialVersionUID = 1L;
			
			String id, trgId;
			
			
			String originalFilePath;
			
			
			AbstractTypeDeclaration type; Boolean typeIsComposed = false;
			
			CompilationUnit attachedSource; Boolean attachedSourceIsComposed = false;
			
			Package package_; Boolean packageIsComposed = false;
			
			
			public ClassFile(){ }
			
			
			public ClassFile(
				String id,				
				String name,				Boolean proxy,				String originalFilePath
				,
				Comment comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile,				ImportDeclaration usagesInImports,				AbstractTypeDeclaration type,				CompilationUnit attachedSource,				Package package_ ){
				
				super(				name,				proxy				,
				comments
				,				originalCompilationUnit
				,				originalClassFile
				,				usagesInImports
);
				
				this.id = id;
				
				
				this.originalFilePath = originalFilePath ;
				
				this.type = type ;
				this.attachedSource = attachedSource ;
				this.package_ = package_ ;
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
			
			
			
			public void setType(AbstractTypeDeclaration type) {
				this.type = type;
			}
				
			public AbstractTypeDeclaration getType() {
				return type;
			}
			
			public void setAttachedSource(CompilationUnit attachedSource) {
				this.attachedSource = attachedSource;
			}
				
			public CompilationUnit getAttachedSource() {
				return attachedSource;
			}
			
			public void setPackage(Package package_) {
				this.package_ = package_;
			}
				
			public Package getPackage() {
				return package_;
			}
			
		}
	