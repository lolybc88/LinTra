
		package javaMMinJava;
		
		import blackboard.IdentifiableElement;
		import java.io.Serializable;
	
		public  class AnnotationTypeMemberDeclaration  extends BodyDeclaration implements Serializable, IdentifiableElement {
			
			private static final long serialVersionUID = 1L;
			
			String id, trgId;
			
			
			
			
			Expression default; Boolean defaultIsComposed = true;
			
			TypeAccess type; Boolean typeIsComposed = true;
			
			AnnotationMemberValuePair usages; Boolean usagesIsComposed = false;
			
			
			public AnnotationTypeMemberDeclaration(){ }
			
			
			public AnnotationTypeMemberDeclaration(
				String id,				
				String name,				Boolean proxy
				,
				Comment comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile,				ImportDeclaration usagesInImports,				AbstractTypeDeclaration abstractTypeDeclaration,				Annotation annotations,				AnonymousClassDeclaration anonymousClassDeclarationOwner,				Modifier modifier,				Expression default,				TypeAccess type,				AnnotationMemberValuePair usages ){
				
				super(				name,				proxy				,
				comments
				,				originalCompilationUnit
				,				originalClassFile
				,				usagesInImports
				,				abstractTypeDeclaration
				,				annotations
				,				anonymousClassDeclarationOwner
				,				modifier
);
				
				this.id = id;
				
				
				
				this.default = default ;
				this.type = type ;
				this.usages = usages ;
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
			
			
			
			
			
			public void setDefault(Expression default) {
				this.default = default;
			}
				
			public Expression getDefault() {
				return default;
			}
			
			public void setType(TypeAccess type) {
				this.type = type;
			}
				
			public TypeAccess getType() {
				return type;
			}
			
			public void setUsages(AnnotationMemberValuePair usages) {
				this.usages = usages;
			}
				
			public AnnotationMemberValuePair getUsages() {
				return usages;
			}
			
		}
	