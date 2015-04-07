
		package javaMMinJava;
		
		import blackboard.IdentifiableElement;
		import java.io.Serializable;
	
		public  class ClassDeclaration  extends TypeDeclaration implements Serializable, IdentifiableElement {
			
			private static final long serialVersionUID = 1L;
			
			String id, trgId;
			
			
			
			
			TypeAccess superClass; Boolean superClassIsComposed = true;
			
			
			public ClassDeclaration(){ }
			
			
			public ClassDeclaration(
				String id,				
				String name,				Boolean proxy,
				Comment comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile,				ImportDeclaration usagesInImports,				AbstractTypeDeclaration abstractTypeDeclaration,				Annotation annotations,				AnonymousClassDeclaration anonymousClassDeclarationOwner,				Modifier modifier,				TypeAccess usagesInTypeAccess,				BodyDeclaration bodyDeclarations,				Comment commentsBeforeBody,				Comment commentsAfterBody,				Package package_,				TypeAccess superInterfaces,				TypeParameter typeParameters,				TypeAccess superClass ){
				
		super(name, proxy, comments, originalCompilationUnit,
				originalClassFile, usagesInImports, abstractTypeDeclaration,
				annotations, anonymousClassDeclarationOwner, modifier,
				usagesInTypeAccess, bodyDeclarations, commentsBeforeBody,
				commentsAfterBody, package_, superInterfaces, typeParameters);
				
				this.id = id;
				
				
				
				this.superClass = superClass ;
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
			
			
			
			
			
			public void setSuperClass(TypeAccess superClass) {
				this.superClass = superClass;
			}
				
			public TypeAccess getSuperClass() {
				return superClass;
			}
			
		}
	