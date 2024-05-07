Pod::Spec.new do |spec|
    spec.name                     = 'BaseUiKit'
    spec.version                  = '1.0'
    spec.homepage                 = 'https://github.com/Pie-Roman/News-BDUI-KMP'
    spec.source                   = { :git => "local", :tag => "#{spec.version}" }
    spec.authors                  = ''
    spec.license                  = ''
    spec.summary                  = 'Base ui kit module'
    spec.ios.deployment_target = '12.0'
    spec.public_header_files = 'Sources/**/*.h'
    spec.source_files            = [
      'Sources/**/*.{swift,h,m}'
    ]

    spec.dependency 'CommonUmbrella'
end
